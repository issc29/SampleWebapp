<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous">
        </script>
        <script>
            $(document).on("click", "#submit", function() {
               $.get( "/sum", { number1: $("#number1").val(), number2: $("#number2").val() } )
                                 .done(function( data ) {
                                   $("#sumTotal").val(data);
                                 });
            });
        </script>
    </head>

    <body>

        <h2>Addition</h2>

          <input type="text" id="number1" name="number1" />
          +
          <input type="text" id="number2" name="number2" />
          =
          <input type="text" id="sumTotal"  />
          <br/>
          <input type="submit" id="submit" />


    </body>
</html>
