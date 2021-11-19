package hu.uni.miskolc.iit.webalk.adatb.service;

public class NoSuchEntityException extends RuntimeException {

    private Long id;
    public NoSuchEntityException(Long id){
        super(String.format("No such entity%id",id));
        this.id=id;
    }
    public Long getId(Long id) {
        return id;
    }

}
