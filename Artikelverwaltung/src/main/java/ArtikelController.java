import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    private int index = 0;

    @Inject
    Shop shop;

    @Inject
    CurrentUser currentUser;

    public Artikel getArtikel()
    {
        return shop.getSortiment().get(index);
    }

    public void vor()
    {
      if (index < shop.getSortiment().size() - 1) {
        index++;
      }
    }

    public void zurueck()
    {
      if (index > 0) {
        index--;
      }
    }

    public void removeArtikel() {
        if(!shop.getSortiment().isEmpty())
            shop.getSortiment().remove(index);
    }

    public int getIndex()
    {
        return index;
    }

    public int getMaxIndex() {
    	return shop.getSortiment().size()-1;
    }


}
