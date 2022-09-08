package com.example.utils;

import java.util.HashMap;

//query.select().from().where()
public class QueryBuilder {
    private StringBuilder sb;
    private boolean ORDER_BY = false;
    private boolean SET = false;
    private boolean INSERT = false;
    HashMap<String, Object> column_values;

    public QueryBuilder() {
        this.sb = new StringBuilder();
        column_values = new HashMap<>();
    }

    private void join_operation(String field_name, String operation,
                           Object value) {
        sb.append(field_name + " ");
        sb.append(operation + " ");
        if(value.getClass().getSimpleName().equals("Integer") ||
                value.getClass().getSimpleName().equals("Double") ||
                value.getClass().getSimpleName().equals("Long")) {
            sb.append(value);
            sb.append(" ");
        } else {
            sb.append("'" + value.toString() + "'");
            sb.append(" ");
        }
    }

    public QueryBuilder from(String table) {
        sb.append("FROM ");
        sb.append(table);
        sb.append(" ");
        return this;
    }
    public QueryBuilder select() {
        sb.append("SELECT * ");
        return this;
    }
    public QueryBuilder select(String fieldnames) {
        sb.append("SELECT ");
        sb.append(fieldnames);
        sb.append(" ");
        return this;
    }
    public QueryBuilder where(String field_name, String operation,
                              Object value) {
        sb.append("WHERE ");
        join_operation(field_name, operation, value);
        return this;
    }

    public QueryBuilder and(String field_name, String operation,
                            Object value) {
        sb.append("AND ");
        join_operation(field_name, operation, value);
        return this;
    }
    public QueryBuilder or(String field_name, String operation,
                           Object value) {
        sb.append("OR ");
        join_operation(field_name, operation, value);
        return this;
    }

    public QueryBuilder order_asc(String field_name) {
        if(!ORDER_BY) {
            sb.append("ORDER BY ");
            ORDER_BY = true;
        } else {
            sb.append(", ");
        }
        sb.append(field_name);
        sb.append(" ");
        sb.append("ASC ");
        return this;
    }
    public QueryBuilder order_desc(String field_name) {
        if(!ORDER_BY) {
            sb.append("ORDER BY ");
            ORDER_BY = true;
        } else {
            sb.append(", ");
        }
        sb.append(field_name);
        sb.append(" ");
        sb.append("DESC ");
        return this;
    }

    public QueryBuilder limit(int number) {
        sb.append("LIMIT ");
        sb.append(number);
        sb.append(" ");
        return this;
    }
    public QueryBuilder limit(int offset, int number) {
        sb.append("LIMIT ");
        sb.append(offset);
        sb.append(",");
        sb.append(number);
        sb.append(" ");
        return this;
    }

    public QueryBuilder update(String table_name) {
        sb.append("UPDATE ");
        sb.append(table_name);
        sb.append(" SET ");
        return this;
    }

    public QueryBuilder set(String field_name, Object value) {
        if(!SET) {
            SET = true;
        } else {
            sb.append(",");
        }
        join_operation(field_name, "=", value);
        return this;
    }

    public QueryBuilder insert_into(String table) {
        INSERT = true;
        sb.append("INSERT INTO ");
        sb.append(table);
        sb.append(" ");
        return this;
    }

    public QueryBuilder column_value(String column, Object value) {
        column_values.put(column, value);
        return this;
    }

    public String toString() {
        if(INSERT) {
            boolean is_first = true;
            StringBuilder sb_columns = new StringBuilder();
            StringBuilder sb_values = new StringBuilder();
            sb_columns.append("(");
            sb_values.append("(");
            for(String key : column_values.keySet()) {
                if(is_first) { is_first = false; }
                else {
                    sb_columns.append(",");
                    sb_values.append(",");
                }
                sb_columns.append(key);
                sb_values.append("'" + column_values.get(key) + "'");
            }
            sb_columns.append(")");
            sb_values.append(")");
            sb.append(sb_columns.toString());
            sb.append(" VALUES ");
            sb.append(sb_values.toString());
        }
        return sb.toString();
    }
}