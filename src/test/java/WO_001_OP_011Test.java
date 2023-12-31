import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WO_001_OP_011Test extends Hooks1 {

	@Test
	void testLoginProcessWithValidInputs() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/weborder']")));
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username-input")));

		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		By elementLocator = By.id("welcome-heading");
		wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		WebElement heading = driver.findElement(By.id("welcome-heading"));
		String headingText = heading.getText();
		Assertions.assertEquals("Welcome, Inar!", headingText, "Error!");
	}

}
