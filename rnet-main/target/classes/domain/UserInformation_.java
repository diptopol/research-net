package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserInformation.class)
public abstract class UserInformation_ {

	public static volatile SingularAttribute<UserInformation, String> address;
	public static volatile SingularAttribute<UserInformation, String> email;
	public static volatile SingularAttribute<UserInformation, String> profession;
	public static volatile SingularAttribute<UserInformation, String> name;
	public static volatile SingularAttribute<UserInformation, User> user;

}

