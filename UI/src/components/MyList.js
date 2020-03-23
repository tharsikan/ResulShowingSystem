import React, { Component } from 'react'
import axios from 'axios'

class MyList extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             posts:[]
        }
    }
    componentDidMount(){
        // axios.get
        // axios({
        //     "url": 'http://localhost:8013/batch/1/allocation?id=1',
        //     "method": "GET",
        //     "headers": {
        //         'Access-Control-Allow-Origin': '*',
        //         'Content-Type': 'application/x-www-form-urlencoded',
        //         'Accept': 'application/json'
        //     }
        // })
        //     .then(response=>{
        //         console.log(response)
        //     })
        //     .catch(error=>{
        //         console.log(error)
        //     })
        axios.get('http://localhost:8013/batch/1/allocation?id=1')
            .then(response=>{
                    console.log(response)
                    this.setState({posts: response.data})
                })
            .catch(error=>{
                    console.log(error)
                })
    }
    render() {
        return (
            <div>
                
            </div>
        )
    }
}

export default MyList
