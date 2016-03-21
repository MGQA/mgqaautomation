package com.motionglobal.common.webdriver;

import org.apache.log4j.Logger;

/**
 * This class allows you to assert a condition that may not be true right at the moment, but should become true within a specified time frame. To use it, simply
 * replace calls like:
 * 
 * assert(someCondition);
 * 
 * With:
 * 
 * new RetriedAssert(5000, 250) { // timeout, interval
 * 
 * public void run() throws Exception { assert(someCondition); } }.start();
 * 
 * The start() and run() methods were named after those in java.lang.Thread, whose function they mimic.
 * 
 * This class was written by Model N, Inc. You may use it and modify it any way you wish--but please leave this message intact.
 * 
 * @author Kevin Bourrillion (kevinb@modeln.com)
 */
public abstract class RetriedAssert {
    private final Logger log = Logger.getLogger(RetriedAssert.class);
    private final int _timeOutMs;
    private final int _intervalMs;

    protected RetriedAssert(int timeOutMs, int intervalMs) {
        _timeOutMs = timeOutMs;
        _intervalMs = intervalMs;
    }

    public final void start() throws Exception {
        long stopAt = System.currentTimeMillis() + _timeOutMs;
        int retried = 1;
        while (System.currentTimeMillis() < stopAt) {
            try {
                run();
                return;
            }
            catch (AssertionError ignoreAndRetry) {
                log.info("Assertion failed. Retring..." + (retried++));
            }
            try {
                Thread.sleep(_intervalMs);
            }
            catch (InterruptedException ie) {
            }
        }
        // All tries have failed so far. Try one last time,
        // now letting any failure pass out to the caller.
        run();
    }

    public abstract void run() throws Exception;
}