// Source: https://gist.github.com/andytill/3835914
// Used for a JavaFX instantiation error with JUnit tests

package test;

import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A JUnit {@link Rule} for running tests on the JavaFX thread and performing
 * JavaFX initialisation.  To include in your test case, add the following code:
 * 
 * <pre>
 * {@literal @}Rule
 * public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
 * </pre>
 * 
 * @author Andy Till
 * 
 */
public class JavaFXThreadingRule implements TestRule {
    
    /**
     * Flag for setting up the JavaFX, we only need to do this once for all tests.
     */

    @Override
    public Statement apply(Statement statement, Description description) {
        
        return new OnJFXThreadStatement(statement);
    }

    private static class OnJFXThreadStatement extends Statement {
        
        private final Statement statement;

        public OnJFXThreadStatement(Statement aStatement) {
            statement = aStatement;
        }

        private Throwable rethrownException = null;
        
        @Override
        public void evaluate() throws Throwable {
            
        		setupJavaFX();
            
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            
            countDownLatch.countDown();
            statement.evaluate();
            countDownLatch.await();
            
            // if an exception was thrown by the statement during evaluation,
            // then re-throw it to fail the test
            if(rethrownException != null) {
                throw rethrownException;
            }
        }

        protected void setupJavaFX() throws InterruptedException {
            
            final CountDownLatch latch = new CountDownLatch(1);

            SwingUtilities.invokeLater(() -> {new JFXPanel(); latch.countDown();});
            
            latch.await();
        }
        
    }
}

