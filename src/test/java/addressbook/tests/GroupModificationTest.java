package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("Updated group")
                .withHeader(null)
                .withFooter(null);
        app.group().modify(group);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();


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
