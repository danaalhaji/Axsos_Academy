import React, { Component } from 'react';

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ageCount: this.props.age,
        };
    }
    happyBirthday=() => {
        this.setState({ageCount : this.state.ageCount+1})
    }
    render() {
        return (
            <div>
            <h1>{this.props.firstName}, {this.props.lastName}</h1>
            <p>
              Age: {this.state.ageCount}
            </p>
            <p>
              Hair Color: {this.props.hairColor}
            </p>
            <button onClick={this.happyBirthday}>Happy Birthday {this.props.firstName}</button>
          </div>
        );
    }
}

export default Header
