package org.lookup.service.constants;

public enum DBLinks {
    MY_SQL_DB_LINK, UNSUPPORTED_DB_LINK;

    @Override
    public String toString() {
        switch(this) {
            case MY_SQL_DB_LINK: return "jdbc:mysql://";
            default: return UNSUPPORTED_DB_LINK.name();
        }
    }
}