import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/home");
		
		//*[@id="menu"]/a[4]
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[4]")).click();
	}
	
	@Test
	public void TestarLogin(){
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botão = driver.findElement(By.id("botão-enviar"));
		
		try {
			//Caso de teste de Email Incorreto
			campoEmail.sendKeys("caio@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botão.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Senha incorreta para um email cadastrado
			campoEmail.sendKeys("fernando@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botão.click();
			
			Thread.sleep(3000);
			
			//usuario correto
			campoEmail.sendKeys("fernando@email.com");
			campoSenha.sendKeys("senhadofernando");
			botão.click();
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void EncerrarTeste(){
		
	}
	
	
}
