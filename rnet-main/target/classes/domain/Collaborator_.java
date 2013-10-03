package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Collaborator.class)
public abstract class Collaborator_ {

	public static volatile SingularAttribute<Collaborator, String> role;
	public static volatile SingularAttribute<Collaborator, User> user;
	public static volatile SingularAttribute<Collaborator, Research> research;

}

