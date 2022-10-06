package Model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<User> {

   private Set<User> delegate;

    @Override
    protected Set<User> delegate() {
        return delegate;
    }

    public Users(Users users){
        this.delegate = new HashSet<>(users.delegate);
    }

    public Users(Collection<User> users){
        this.delegate = new HashSet<User>(users);
    }

    public Users() {
        this.delegate = new HashSet<>();
    }

}
