package ge.tsu.client.view;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import ge.tsu.client.images.Images;
import ge.tsu.client.presenter.Form200_2Presenter;

/**
 * Created by vako on 19/06/14.
 */
public class Form200_2View implements Form200_2Presenter.Display {

    @Override
    public Widget asWidget() {

	    VerticalLayoutContainer vlc = new VerticalLayoutContainer();
	    vlc.setScrollMode(ScrollSupport.ScrollMode.AUTOY);
	    vlc.add(new Image(Images.INSTANCE.form200_2()), new VerticalLayoutContainer.VerticalLayoutData(1, -1));
	    return vlc;
    }
}
