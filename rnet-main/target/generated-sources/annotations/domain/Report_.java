package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Report.class)
public abstract class Report_ {

	public static volatile SingularAttribute<Report, Milestone> milestone;
	public static volatile SingularAttribute<Report, Date> reportingTime;
	public static volatile SingularAttribute<Report, String> reportStatus;
	public static volatile SingularAttribute<Report, byte[]> reportData;
	public static volatile SingularAttribute<Report, User> user;
	public static volatile SingularAttribute<Report, Integer> reportId;
	public static volatile ListAttribute<Report, Feedback> feedbackList;

}

