'use strict';

var App = React.createClass({
    render() {
        return (
            <div>
                <h1>Yo</h1>
                <Pokerhand />
            </div>
        );
    }
});

React.render(<App />, document.getElementById('content'));