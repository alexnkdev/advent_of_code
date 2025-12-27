let () =
  print_endline "Hello, world!"

let x = 10
let message = "Hello"

let y = ref 5

let () =
  y := !y + 1;
  Printf.printf "%d\n" !y
