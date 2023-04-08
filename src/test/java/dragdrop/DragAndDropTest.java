package dragdrop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    private final String URL = "https://the-internet.herokuapp.com/drag_and_drop";
    private SelenideElement columnA = $(Selectors.byId("column-a"));
    private SelenideElement columnB = $(Selectors.byId("column-b"));
    private SelenideElement headerA = $(Selectors.byTagAndText("header", "A"));
    private SelenideElement headerB = $(Selectors.byTagAndText("header", "B"));

    @Test
    public void dragDropTest(){
        open(URL);
        columnB.shouldHave(Condition.text(headerB.getText()));
        columnA.dragAndDropTo(columnB);
        columnB.shouldHave(Condition.text(headerA.getText()));
    }
}
