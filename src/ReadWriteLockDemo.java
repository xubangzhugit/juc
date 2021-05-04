import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args){
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();//读锁
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();//写锁
        readWriteLock.writeLock().unlock();
    }
}
