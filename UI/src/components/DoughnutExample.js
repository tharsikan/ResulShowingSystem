import React,{useState, useEffect} from 'react';
import {Doughnut} from 'react-chartjs-2';

export default function DoughnutExample(props) {
	const [data,setData] = useState(
		{
		labels: [
			'Earned Gpa'
		],
		datasets: [{
			data: [100,200],
			backgroundColor: [
			'#FF6384',
			'#daded7'
			],
			hoverBackgroundColor: [
			'#FF6384',
			'#daded7'
			]
		}]
		}
	);
	// data.datasets.data[0] = props.number;
	// let func = () => {
		// telephoneList: [course.telephoneList[0]={number: phone1},course.telephoneList[1]={number: phone2}] 
	
		// setData({...data, labels: [data.labels[0]='Orange']  })

	// 	data.datasets[0].data[0]=props.number;
	// 	data.datasets[0].data[1]=4000-props.number;
	//   };

	useEffect(()=>{
		setData({...data, labels: [data.labels[0]=props.number]})
		setData({...data, datasets: [data.datasets[0]={...data.datasets[0], data:[props.number,4.000-props.number]} ] })
		if(props.number>=3){
		setData({...data, datasets: [data.datasets[0]={...data.datasets[0],data:[props.number,4.000-props.number], backgroundColor:['#80df72'], hoverBackgroundColor:['#76fc00']} ] })
		}
		else if(props.number>=2){
			setData({...data, datasets: [data.datasets[0]={...data.datasets[0],data:[props.number,4.000-props.number], backgroundColor:['#ecec03'], hoverBackgroundColor:['#ffff00']} ] })
		}
    },[])
	console.log(props.number);
	return (	
		<div>
        <h2>{props.head}</h2>
        <Doughnut data={data} />
      </div>
	)
}
