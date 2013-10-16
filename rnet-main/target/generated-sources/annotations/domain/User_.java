package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> username;
	public static volatile ListAttribute<User, Collaborator> collaboratorList;
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile ListAttribute<User, Report> reportList;
	public static volatile SingularAttribute<User, UserInformation> userInformation;
	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Feedback> feedbackList;

}

