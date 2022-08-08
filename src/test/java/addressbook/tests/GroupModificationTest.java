package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("Updated group")
                .withHeader(null)
                .withFooter(null);
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);


//        method(1, 2, new MySum());
//        method(1, 2, new MyOperation() {
//            @Override
//            public Integer make(Integer lho, Integer rho) {
//                return lho - rho;
//            }
//        });
//        method(1, 2, (lho, rho) -> lho - rho);
//    }
//
//    interface MyOperation {
//        Integer make(Integer lho, Integer rho);
//    }
//    class MySum implements MyOperation {
//        public Integer make(Integer lho, Integer rho) {
//            return lho + rho;
//        }
    }



//    public void method(Integer lho, Integer rho, MyOperation op) {
//        System.out.println(op.make(lho, rho));
//    }


}
