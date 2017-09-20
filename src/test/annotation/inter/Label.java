package test.annotation.inter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public  @interface Label{
	
    public abstract int colIndex();
}
