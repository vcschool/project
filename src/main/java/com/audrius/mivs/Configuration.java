package com.audrius.mivs;

import java.io.Serializable;

class Configuration implements Serializable {
    private boolean initialized;

    boolean isInitialized() {
        return initialized;
    }

    void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
}
