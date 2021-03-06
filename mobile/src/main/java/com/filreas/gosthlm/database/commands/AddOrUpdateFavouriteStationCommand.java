package com.filreas.gosthlm.database.commands;

import com.filreas.gosthlm.database.helpers.IFavouriteSiteDbHelper;
import com.filreas.gosthlm.database.model.FavouriteSite;
import com.filreas.gosthlm.database.queries.IDataSourceChanged;

public class AddOrUpdateFavouriteStationCommand implements ICommand {

    private final IFavouriteSiteDbHelper favouriteSiteHelper;
    private final IDataSourceChanged dataSourceChangedListener;
    private final FavouriteSite item;

    public AddOrUpdateFavouriteStationCommand(
            IFavouriteSiteDbHelper favouriteSiteHelper,
            IDataSourceChanged dataSourceChanged,
            FavouriteSite item) {

        this.favouriteSiteHelper = favouriteSiteHelper;
        this.dataSourceChangedListener = dataSourceChanged;
        this.item = item;
    }

    @Override
    public void execute() {
        FavouriteSite current = favouriteSiteHelper.getBySiteId(item.getSiteId());
        if (current == null) {
            favouriteSiteHelper.create(item);
            if(dataSourceChangedListener != null) {
                dataSourceChangedListener.dataSourceChanged();
            }
        } else {
            item.setId(current.getId());
            if (current.compareTo(item) != 0) {
                favouriteSiteHelper.update(item);
            }
        }
    }
}
