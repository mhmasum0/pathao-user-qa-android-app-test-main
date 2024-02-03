package com.pathao.user.qa.utils;


import com.pathao.user.qa.core.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenShot {

    AndroidDriver androidDriver;

    public ScreenShot(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void pageScreenshot(){
        File screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.FILE);
        String path = String.format("%s/pages/%s.png", Constants.SCREENSHOT_PATH, UUID.randomUUID());
        File screenshotFile =  new File( path );

        try {
            FileUtils.copyFile(screenshot,screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void elementScreenShotPath( By locator){
        WebElement element = androidDriver.findElement(locator);
        File screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.FILE);

        try {


            Point point = element.getLocation();
            int elementWidth = element.getSize().getWidth();
            int elementHeight = element.getSize().getHeight();

            BufferedImage fullImage = ImageIO.read(screenshot);
            BufferedImage elementImage = fullImage.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
            ImageIO.write(elementImage,"png",screenshot);

            String path = String.format("%s/elements/%s-%s.png", Constants.SCREENSHOT_PATH, element.getText() , UUID.randomUUID());
            File screenshotFile =  new File( path );
            FileUtils.copyFile(screenshot,screenshotFile);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
