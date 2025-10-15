package bases;

public abstract class BaseController {
    protected BasePage page;

    protected BaseController(BasePage page){
        this.page = page;
    }
}
