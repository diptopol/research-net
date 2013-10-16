package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Milestone.class)
public abstract class Milestone_ {

	public static volatile SingularAttribute<Milestone, String> milestoneStatus;
	public static volatile SingularAttribute<Milestone, Integer> sequence;
	public static volatile SingularAttribute<Milestone, String> description;
	public static volatile ListAttribute<Milestone, Report> reportList;
	public static volatile SingularAttribute<Milestone, Research> research;
	public static volatile SingularAttribute<Milestone, Integer> milestoneId;

}

