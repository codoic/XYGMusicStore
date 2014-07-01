package persistance.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistance.entity.CustomerOrder;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-06-17T22:17:43")
@StaticMetamodel(LineItems.class)
public class LineItems_ { 

    public static volatile SingularAttribute<LineItems, Integer> quantity;
    public static volatile SingularAttribute<LineItems, String> itemid;
    public static volatile SingularAttribute<LineItems, Integer> lineId;
    public static volatile SingularAttribute<LineItems, CustomerOrder> orderId;

}