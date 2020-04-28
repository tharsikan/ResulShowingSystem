import React from 'react'
import './../App.css'
import {Link} from 'react-router-dom'


export default function NavBar() {
    const link_style = {
        color: "white"
    }

    return (
        <nav>
            <ul className="nav-links">
                <Link style={link_style} to="/add_student">
                    <li>Add Student</li>
                </Link>
                <Link style={link_style} to="/add_course">
                    <li>Add Course</li>
                </Link>
            </ul>
        </nav>
    )
}

