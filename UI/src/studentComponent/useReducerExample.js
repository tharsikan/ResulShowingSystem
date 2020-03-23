import React,{useReducer} from 'react'

const initState ={
    firstCount:0,
    secoundCount:5
}
const reducer = (state,action) =>{
    switch(action.type){
        case 'increment1':
            return {...state, firstCount: state.firstCount +action.value};
        case 'decrement1':
            return {...state,firstCount: state.firstCount -action.value};
        case 'increment2':
            return {...state,secoundCount: state.secoundCount +action.value};
        case 'decrement2':
            return {...state,secoundCount: state.secoundCount -action.value};
        case 'reset':
            return initState;
        default:
            return state;
    }
}

function useReducerExample() {
    const [count,dispatch] = useReducer(reducer,initState);
    return (
        <div>
            <h3>firstCount: {count.firstCount} secoundCount: {count.secoundCount}</h3>
            <button onClick={()=>dispatch({type:'increment1', value:5})}>increment1</button>
            <button onClick={()=>dispatch({type:'decrement1', value:5})}>decrement1</button>
            <button onClick={()=>dispatch({type:'increment2', value:3})}>decrement2</button>
            <button onClick={()=>dispatch({type:'decrement2', value:3})}>decrement2</button>
            <button onClick={()=>dispatch({type:'reset'})}>reset</button>
        </div>
    )
}

export default useReducerExample
