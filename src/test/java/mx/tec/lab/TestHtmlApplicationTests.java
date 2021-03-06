package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

@SpringBootTest
class TestHtmlApplicationTests {
	private WebClient webClient;
	
	@BeforeEach
	public void init() throws Exception {
		webClient = new WebClient();
	}
	@AfterEach
	public void close() throws Exception {
		webClient.close();
	}
	@Test
	public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect()
			throws Exception {
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php");
		assertEquals("My Store", page.getTitleText());
	}
	@Test
	public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed()
			throws Exception {
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		emailField.setValueAttribute("A01562038@itesm.mx");
		HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
		passwordField.setValueAttribute("papichulo");
		HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		HtmlPage resultPage = submitButton.click();
		assertEquals("My account - My Store", resultPage.getTitleText());
		}
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed()
			throws Exception {
				fail("Test not yet implemented!");
			}
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed()
			throws Exception {
				fail("Test not yet implemented!");
				}
	@Test
	public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsDisplayed()
			throws Exception {
		fail("Test not yet implemented!");
		}
	@Test
	public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed()
			throws Exception {
		fail("Test not yet implemented!");
		}
	@Test
	public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed()
			throws Exception {
		fail("Test not yet implemented!");
	}
}
