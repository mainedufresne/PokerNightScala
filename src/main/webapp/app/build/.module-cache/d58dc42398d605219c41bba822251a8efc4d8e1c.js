/**
 * Created by chris on 6/8/15.
 */
var Pokerhand = React.createClass(
    {
        displayName: 'Poker Hand',
        render: function() {
            return (
                React.createElement('div', {className: "pokerhand"},
                    "Hello this is a poker hand"
                )
            );
        },
        render: function() {
            return (
                React.createElement("div", null, "This is a Poker hand!")
            );
        }

    }
);
React.render(
    React.createElement(Pokerhand, null),
    document.getElementById('pokerhand')
);