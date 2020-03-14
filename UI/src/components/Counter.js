import React, { Component } from 'react'

class Counter extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             count: 3
        }
        this.increment = this.increment.bind(this)
    }
    increment() {
        this.setState((prevStatte)=>{
            this.state.count = this.state.count + prevStatte.count
        },()=>{console.log(this.state.count)});
    }
    
    render() {
        return (
            <div>
                <h3>
                    {this.state.count}
                </h3>
                <button onClick={this.increment}>increment</button>
            </div>
        )
    }
}

export default Counter
