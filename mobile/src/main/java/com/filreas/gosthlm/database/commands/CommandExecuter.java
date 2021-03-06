package com.filreas.gosthlm.database.commands;

import android.os.AsyncTask;

public class CommandExecuter extends AsyncTask<ICommand, Void, Void> {

    @Override
    protected Void doInBackground(ICommand... params) {
        for (ICommand command : params) {
            command.execute();
        }

        return null;
    }
}
