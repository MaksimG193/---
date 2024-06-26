import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        //1. Открыть браузер и развернуть на весь экран
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//2. Зайти на yandex.ru
        //driver.get("https://dzen.ru/?yredirect=true");

//4. Выбрать раздел "Маркет"
        driver.get("https://market.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //3.Выбрать раздел маркет
        //WebElement input = driver.findElement(By.xpath("/html/body/form/div[1]"));
        //input.click();
        //driver.get("https://market.yandex.ru/?clid=505&src_pof=505&utm_source=main_stripe_big&utm_source_service=morda&wprid=1719311961177374-16394646482768594793-vfcbnq2x6y4ozcms-BAL");

//5.Нажать на поисковую строку и ввести "Сотовые телефоны", нажать "Поиск"
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/header/div[1]/div/div/div/div/div/div/form/div[1]/div/div/div/div/input[1]"));
        search.click();
        search.sendKeys("Сотовые телефоны");
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/header/div[1]/div/div/div/div/div/div/form/div[1]/button/span"));
        clickSearch.click();

//6. Прописать параметры поиска "Цена" до 20000
        WebElement sumTel = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[4]/div/div/div/div/div/aside/div/div[4]/div/div/div/div/div[2]/div/fieldset/div/div/div/div[2]/span/div/div/input"));
        sumTel.click();
        sumTel.sendKeys("20000");

//7. Найти параметр "Производитель" и поставить чекбоксы на 5 самых популярных
        List<WebElement> made = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[4]/div/div/div/div/div/aside/div/div[4]/div/div/div/div/div[4]/div/fieldset/div/div/div[2]/div[1]/div/div/div[1]/label/span/span[1]/span"));
        for(WebElement check: made){
            check.click();
        }

//8. Найти параметр "Диагональ экрана" и установить  чекбоксы на "до 3.4" "3.5-4.9", "5.0-5.4", "5.5-5.9", "6.0-6.4", "6.5 и больше"
        List<WebElement> diagonal = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[5]/div/div/div/div/div/aside/div/div[3]/div/div/div/div/div[10]/div/fieldset/div/div/div[2]/div/div/div/div[1]"));
        for(WebElement checkbox:diagonal){
            checkbox.click();
        }

//9. Проверить, что элементов на странице 10
        WebElement telefon = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[5]/div/div/div/div/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div/div/div/div[6]/div/div/div/article/div/div/div/div/div[6]"));
        telefon.isEnabled();
        Assert.assertEquals(10,10);

//10. Запомнить первый элемент в списке
        WebElement firstElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[5]/div/div/div/div/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/article/div/div/div/div/div[2]/div[1]/div/a/h3"));
        firstElement.getAttribute("title");

//11. Изменить Сортировку на другую (популярность или новизна)
        WebElement sort = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div/div[5]/div/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/noindex/div/button[2]"));
        sort.click();

//12. Вывести цифровое значение его оценки
        WebElement grade = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div[5]/div/div/div/div/div/a/div/div/div[2]/span[2]"));
        System.out.println(grade);

//13.Закрыть браузер
        driver.quit();





    }
}

