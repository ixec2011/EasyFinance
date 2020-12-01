package ru.ixec.easyfinance.bot;

import com.google.common.base.Strings;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.extern.slf4j.Slf4j;
import ru.ixec.easyfinance.exception.BotException;
import ru.ixec.easyfinance.type.KeyboardType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

@Slf4j
public class DecoderPhotoQR {

    public static String decode(File qrCodeImage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeImage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<>(DecodeHintType.class) {{
                put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            }};
            Result result = new MultiFormatReader().decode(bitmap, tmpHintsMap);
            if (Strings.isNullOrEmpty(result.getText()))
                return null;
            return result.getText();
        } catch (NotFoundException e) {
            throw new BotException("Ошибка получения фотографии!", KeyboardType.CANCEL);
        }
    }
}
