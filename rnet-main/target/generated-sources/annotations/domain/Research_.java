package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Research.class)
public abstract class Research_ {

	public static volatile ListAttribute<Research, Milestone> milestoneList;
	public static volatile SingularAttribute<Research, String> researchTitle;
	public static volatile ListAttribute<Research, Collaborator> collaboratorList;
	public static volatile SingularAttribute<Research, Date> startingTime;
	public static volatile SingularAttribute<Research, String> researchStatus;
	public static volatile SingularAttribute<Research, byte[]> researchData;
	public static volatile SingularAttribute<Research, Integer> researchId;

}

