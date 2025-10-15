package controllers;

import bases.BaseController;
import views.OptionsPage;

public class OptionsController extends BaseController {
    public OptionsPage getOptionsPage(){ return (OptionsPage)this.page; }

    public OptionsController(OptionsPage optionsPage){
        super(optionsPage);
    }
}
