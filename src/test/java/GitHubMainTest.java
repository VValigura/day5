import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GitHubMainTest {
    /*1. На главной странице GitHub выберите меню Solutions -> Enterprize
    с помощью команды hover для Solutions.
    Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."

2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
 - Откройте https://the-internet.herokuapp.com/drag_and_drop
 - Перенесите прямоугольник А на место В
 - Проверьте, что прямоугольники действительно поменялись
 - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
*/


    @Test
    public void checkSolutionMain(){
        open("https://github.com/");
        $("nav[aria-label='Global']").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").find(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));


    }

    @Test
    public void DragDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        String columnOneName = $(".column").getText();
        actions().dragAndDrop( $("#column-a"), $("#column-b")).perform();
        $(".column").shouldNotHave(text(columnOneName));
    }


}
