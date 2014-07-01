package persistance.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistance.entity.LineItems;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-17T22:17:43")
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ { 

    public static volatile SingularAttribute<CustomerOrder, Double> totalamt;
    public static volatile CollectionAttribute<CustomerOrder, LineItems> lineItemsCollection;
    public static volatile SingularAttribute<CustomerOrder, Integer> orderId;
    public static volatile SingularAttribute<CustomerOrder, Integer> custid;

}