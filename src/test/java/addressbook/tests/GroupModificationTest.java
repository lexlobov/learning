package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId())
                .withName("Updated group")
                .withHeader(null)
                .withFooter(null);
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
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
