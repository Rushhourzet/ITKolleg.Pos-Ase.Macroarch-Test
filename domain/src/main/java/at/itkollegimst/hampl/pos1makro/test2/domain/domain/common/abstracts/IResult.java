package at.itkollegimst.hampl.pos1makro.test2.domain.domain.common.abstracts;

public abstract class IResult<TData> {
    private TData result;
    private Error error;

    public IResult(TData data){            
        this.result = data;
    }
    public IResult(Error error){            
        this.error = error;
    }

    public TData GetData(){
        return result;
    }
    public Error GetError(){
        return error;   
    }

    public boolean isSuccessful(){
        return result != null;
    }
    public boolean failed(){
        return error != null;
    }
}
