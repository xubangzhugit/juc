import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

        public static void main(String[] args) throws ExecutionException, InterruptedException {

            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName());
            });
            voidCompletableFuture.get();
            CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                return "";
            });
           /// stringCompletableFuture.whenComplete().thenAccept();
        }
}
