package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feedback.class)
public abstract class Feedback_ {

	public static volatile SingularAttribute<Feedback, Report> report;
	public static volatile SingularAttribute<Feedback, byte[]> feedbackData;
	public static volatile SingularAttribute<Feedback, Date> feedbackTime;
	public static volatile SingularAttribute<Feedback, Integer> feedbackId;
	public static volatile SingularAttribute<Feedback, User> user;

}

