package BELAJAR_SELENIUM.Checkbox_Radio_Dropdown;

import org.openqa.selenium.By;

import static common.BaseTest.*;

public class HandleCheckbox {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        System.out.println("Default Checkbox: " + driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/input")).isSelected());

        boolean beforeTick = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
        System.out.println("Before Tick: " + beforeTick);
        sleep(1);
        driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
        sleep(1);
        boolean afterTick = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
        System.out.println("After Tick: " + afterTick);

        sleep(2);

        closeDriver();
    }
}
