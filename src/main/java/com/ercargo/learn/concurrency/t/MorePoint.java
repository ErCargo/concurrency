package com.ercargo.learn.concurrency.t;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class MorePoint<T, U, E> {
    private T x;
    private T y;

    private U userName;
    private E pwd;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public U getUserName() {
        return userName;
    }

    public void setUserName(U userName) {
        this.userName = userName;
    }

    public E getPwd() {
        return pwd;
    }

    public void setPwd(E pwd) {
        this.pwd = pwd;
    }
}
