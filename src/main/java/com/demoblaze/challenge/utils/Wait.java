package com.demoblaze.challenge.utils;

import com.demoblaze.challenge.exceptions.ThreadStoppedException;

import static com.demoblaze.challenge.utils.Constants.THREAD_STOPPED_EXCEPTION_MESSAGE;

public class Wait {
    private Wait() {}

    public static void stopExecution(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ThreadStoppedException(THREAD_STOPPED_EXCEPTION_MESSAGE, e);
        }
    }
}
