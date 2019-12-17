package org.lookup.service.constants;

public enum Provider {
    MY_SQL, UNSUPPORTED_DB_ENGINE;

    @Override
    public String toString() {
        switch(this) {
            case MY_SQL: return MY_SQL.name();
            default: return UNSUPPORTED_DB_ENGINE.name();
        }
    }
}