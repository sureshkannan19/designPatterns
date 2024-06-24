package org.sk.designpatterns.proxy.spring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SpringProxyApplication {

    public static void main(String[] args) {
        TransactionalService ts = new TransactionalService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TransactionalService.class);
        enhancer.setCallback(new TransactionMethodInterceptor(ts));
        TransactionalService proxy = (TransactionalService) enhancer.create();
        proxy.performTransaction();
        System.out.println("Proxy class : " + proxy.getClass().getSimpleName());
        System.out.println("Actual class : " + ts.getClass().getSimpleName());
    }

    private static class TransactionalService {
        TransactionalService() {
            System.out.println("Real TransactionalService");
        }

        //        @Transactional
        public void performTransaction() {
            System.out.println("Perform Transaction");
        }
    }

    private static class TransactionMethodInterceptor implements MethodInterceptor {
        private final Object target;

        public TransactionMethodInterceptor(Object target) {
            this.target = target;
            System.out.println("Interceptor created");
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("Transaction started...");
            Object result;
            try {
                result = proxy.invoke(target, args);
            } catch (Exception e) {
                throw e;
            }
            System.out.println("Transaction completed.");
            return result;
        }
    }


}
