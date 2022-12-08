package com.lastpass_generation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

public class Generation {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Initialisation du ChromeDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Liaison avec l'extension LastPass
        driver.get("https://lastpass.com/?ac=1");
        Thread.sleep(5000);

        // Connexion au gestionnaire de mots de passe
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[1]/div/div/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[2]/div/input"));
        email.clear();
        email.sendKeys("noemie.plancherel@gmail.com");
        password.clear();
        password.sendKeys("Ukvaflx9R0YZHb6poLw9");
        Thread.sleep(5000);
        WebElement loginButton = driver.findElement(By.className("euz05gu0"));
        loginButton.click();

        // Accès au menu de génération de mots de passe
        Thread.sleep(8000);
        driver.switchTo().frame("newvault");
        WebElement passButton = driver.findElement(By.xpath("//*[@id=\"advancedMenuItem\"]/div/span"));
        passButton.click();
        Thread.sleep(2000);
        WebElement generateButton = driver.findElement(By.cssSelector("#generatePasswordMenuItem"));
        generateButton.click();
        Thread.sleep(2000);

        // Configuration du nombre de caractères qu'on souhaite, ici on en veut 16
        WebElement numberCar = driver.findElement(By.xpath("//*[@id=\"lengthInput\"]"));
        numberCar.clear();
        numberCar.sendKeys("12");
        Thread.sleep(2000);

        // On coche les cases pour avoir que des lettres minuscules et majuscules
        WebElement digits = driver.findElement(By.xpath("//*[@id=\"generatePasswordDialogDropdownAdvancedOptions" +
                "\"]/div/span[2]/div[3]/div/label"));
        digits.click();
        Thread.sleep(2000);
        // Création d'un fichier local
        File fout = new File("password_12_letters.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Génération de tous les mots de passe et écriture dans le fichier local ligne par ligne
        for (int i = 0; i < 10000; ++i) {
            WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            bw.write(pass.getAttribute("value"));
            bw.newLine();
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"generateBtn\"]"));
            refresh.click();
        }
        bw.close();
        Thread.sleep(3000);
        ////////////// LETTRES + CHIFFRES
        digits.click();
        fout = new File("password_12_letters_digits.txt");
        fos = new FileOutputStream(fout);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10000; ++i) {
            WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            bw.write(pass.getAttribute("value"));
            bw.newLine();
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"generateBtn\"]"));
            refresh.click();
        }
        bw.close();
        Thread.sleep(3000);
        ////////////// LETTRES + SYMBOLES
        digits.click();
        WebElement symbols = driver.findElement(By.xpath("//*[@id=\"generatePasswordDialogDropdownAdvancedOptions" +
                "\"]/div/span[2]/div[4]/div/label"));
        symbols.click();
        Thread.sleep(2000);
        fout = new File("password_12_letters_symbols.txt");
        fos = new FileOutputStream(fout);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10000; ++i) {
            WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            bw.write(pass.getAttribute("value"));
            bw.newLine();
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"generateBtn\"]"));
            refresh.click();
        }
        bw.close();
        Thread.sleep(3000);
        ////////////// DIGITS + SYMBOLES
        WebElement letters_A = driver.findElement(By.xpath("//*[@id=\"generatePasswordDialogDropdownAdvancedOptions" +
                "\"]/div/span[2]/div[1]/div/label"));
        letters_A.click();
        WebElement letters_a = driver.findElement(By.xpath("//*[@id=\"generatePasswordDialogDropdownAdvancedOptions" +
                "\"]/div/span[2]/div[2]/div/label"));
        letters_a.click();
        digits.click();
        Thread.sleep(2000);
        fout = new File("password_12_digits_symbols.txt");
        fos = new FileOutputStream(fout);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10000; ++i) {
            WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            bw.write(pass.getAttribute("value"));
            bw.newLine();
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"generateBtn\"]"));
            refresh.click();
        }
        bw.close();
        Thread.sleep(3000);
        ////////////// ALL
        letters_A.click();
        letters_a.click();
        Thread.sleep(2000);
        fout = new File("password_12_all.txt");
        fos = new FileOutputStream(fout);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10000; ++i) {
            WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            bw.write(pass.getAttribute("value"));
            bw.newLine();
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"generateBtn\"]"));
            refresh.click();
        }
        bw.close();

        Thread.sleep(5000);
        driver.quit();
    }
}
